(ns reagento.tutor)


(comment "Primitives")

(type 1)

(type "hello")

(type #inst"1980-03-05")

(comment "Compound Types")

(type [1 2 3])

(type :key)

(type {:a 1 :b 2})

(type #{"a" "b" "c"})

(comment "Composition")

(defn myfn [x] (* x x))

(myfn 4)

(comment "Interop")

(.. js/window -location -hash)
(comment
  (js/alert "Hello")
  )
