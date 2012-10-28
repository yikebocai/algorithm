
(use  'clojure.string  )

;;去除字符串中多余的空格
(defn remove-redundant-space [str]
  ;按空格分隔并过滤空字符串
  (let [x (filter #(not (blank? %)) (split str #" "))]
    (println x )
    x )  )

(println (join " "  ;将字符串序列按空格分隔并合成一个字符串
           (remove-redundant-space
             "  i ride bike   to longjing   mountain   ")
           )  )
