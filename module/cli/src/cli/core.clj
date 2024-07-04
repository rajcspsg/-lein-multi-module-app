(ns cli.core 
  (:require 
    [common.core :refer :all]))

(defn foo
  "I don't do a whole lot."
  [x]
  (println x (common-fn "x")))


