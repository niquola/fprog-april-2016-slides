(ns reagento.core
    (:require [reagent.core :as reagent :refer [atom]]
              [garden.core :as garden]
              [route-map.core :as rm]
              [goog.events :as events]
              [goog.history.EventType :as EventType])
    (:import goog.History))

(defn style [grdn]
  [:style (garden/css grdn)])


(defn bind [state pth]
  (fn [ev]
    (swap! state assoc-in pth (.. ev -target -value))))

(defn $home-page [params]
  [:div#main
   (style [:body {:padding "20px"
                  :background-color "#f1f1f1"}])
   [:h2 "Hello Clojurescript"]
   [:div [:a {:href "#/form"} "form"]]])

(defn $form [params]
  (let [state (atom {})]
    (js/setInterval (fn [] (swap! state assoc :date (js/Date.))) 1000)
    (fn []
      [:div#main
       (style [:body {:padding "20px"
                      :background-color "#f1f1f1"}])
       [:h2 "Form"]
       [:input {:value (:name @state) :on-change (bind state [:name])}]
       [:pre (pr-str @state)]
       [:br]
       [:a {:href "#/"} "Home"]])))


(def routes
  {:GET  #'$home-page
   "form" {:GET #'$form}})

(defonce current-page (atom $home-page))

(defn dispatch [event]
  (if-let [m (rm/match [:GET (.-token event)] routes)]
    (reset! current-page (:match m))
    (reset! current-page (fn [& args] [:h1 (str "Paget " (.-token event) " not found")]))))

(defn $current-page []
  [:div [@current-page]])

(defn mount-root []
  (reagent/render [$current-page] (.getElementById js/document "app")))

(defn hook-browser-navigation! []
  (doto (History.)
    (events/listen EventType/NAVIGATE dispatch)
    (.setEnabled true)))

(defn init! []
  (hook-browser-navigation!)
  (mount-root))
