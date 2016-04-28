# 5 причин использовать ClojureScript

![](http://www.peoples.ru/art/music/composer/nikolaev/nikolaev_021.jpg)


* langauge design
* essentialy functional & lisp
* REPL-driven interactive development cycle
* eco-system 
* isomorphic apps



## Language Design

JS is awful, clojure is beautiful and simple

**language walkthrough **

## Functional LISP

* immutable datastructures
* separate state

## REPL-driven

* nrepl
* piggyback
* figwheel

IDES:

* emacs
* vim
* idea
* LightTable
* Sublime
* etc


## Eco System

Synergy with React.

Frameworks:

* [reagent](https://reagent-project.github.io/)
* OM & OM-next - https://github.com/omcljs/om
* [RUM](https://github.com/tonsky/rum)
* [quiescent](https://github.com/levand/quiescent)

Tools:

* cljsbuild
* piggyback
* figwheel

Libs:

* core.async
* datascript
* garden
* prismatic schema
* etc


## Isomorpic

```clj

#?{:clj ... :cljs ...}

```
