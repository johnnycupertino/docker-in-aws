(ns swarmpit.component.editor
  (:require [cljsjs.codemirror]
            [cljsjs.codemirror.addon.lint.lint]
            [cljsjs.codemirror.addon.lint.yaml-lint]
            [cljsjs.codemirror.mode.yaml]))

(defn default
  ([editor-id]
   (default editor-id nil))
  ([editor-id editor-settings]
   (js/CodeMirror.fromTextArea
     (.getElementById js/document editor-id)
     (clj->js
       (merge editor-settings
              {:lineNumbers       true
               :viewportMargin    (.-Infinity js/window)
               :matchBrackets     true
               :smartIndent       true
               :tabSize           2
               :indentWithTabs    false
               :autofocus         true
               :autoCloseBrackets true})))))

(defn yaml
  [editor-id]
  (default editor-id {:gutters ["CodeMirror-lint-markers"]
                      :lint    true
                      :mode    "yaml"}))

(defn view
  [editor-id]
  (default editor-id {:readOnly "no-cursor"}))