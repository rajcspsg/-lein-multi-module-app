(defproject lein-multi-module-app "0.1.0-SNAPSHOT"
  :description "This is an example project that has multiple modules like gradle/maven/sbt using leiningen"
  :url "http://example.com/FIXME"
  :license {:name "EPL-2.0 OR GPL-2.0-or-later WITH Classpath-exception-2.0"
            :url "https://www.eclipse.org/legal/epl-2.0/"}
  :plugins [[lein-modules "0.3.11"]]
  :modules {:subprocess nil
            :dirs ["module/common" "module/cli"]
            :inherited {:deploy-repositories
                        [["releases" {:url "https://clojars.org/repo/" :creds :gpg}]]}}
  :release-tasks [["vcs" "assert-committed"]
                  ["change" "version" "leiningen.release/bump-version" "release"]
                  ["modules" "change" "version" "leiningen.release/bump-version" "release"]
                  ["vcs" "commit"]
                  ["vcs" "tag"]
                  ["modules" "deploy"]
                  ["change" "version" "leiningen.release/bump-version"]
                  ["modules" "change" "version" "leiningen.release/bump-version"]
                  ["vcs" "commit"]
                  ["vcs" "push"]])
  
