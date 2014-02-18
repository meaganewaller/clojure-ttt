(defproject clojure-ttt "0.1.0-SNAPSHOT"
  :description "TDD TTT in Clojure"
  :url "http://github.com/meaganewaller/clojure-ttt"
  :license {:name "Eclipse Public License"
            :url "http://www.eclipse.org/legal/epl-v10.html"}
  :dependencies [[org.clojure/clojure "1.5.1"]]
  :profiles {:dev {:dependencies [[speclj "2.9.1"]]}}
  :plugins [[speclj "2.9.1"]]
  :test-paths ["spec"]
  :main clojure-ttt.core)


  
