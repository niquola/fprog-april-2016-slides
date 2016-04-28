(ns reagento.core
    (:require [reagent.core :as reagent :refer [atom]]
              [garden.core :as garden]
              [reagent.session :as session]))

(defn style [grdn]
  [:style (garden/css grdn)])


(defn home-page []
  [:div#main
   (style [:body {:padding "20px"
                  :background-color "#f1f1f1"}])
   [:h2 "Hello Clojurescript"]
   [:div [:a {:href "/about"} "go to about page"]]])

(defn mount-root []
  (reagent/render [home-page] (.getElementById js/document "app")))


(defn init! [] (mount-root))
