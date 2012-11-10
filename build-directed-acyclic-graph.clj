;;rete是规则引擎常用的算法，可以大幅提高规则引擎的执行效率
;P1=C1^C2^C3
;P2=C1^C2^C4
;P3=C1^C2^C4^C5

;;把map中key相等做value合并
(defn merge-map [& maps]
  (reduce (fn [m1 m2]
            (reduce (fn [m [k v]]
                      (update-in m [k] (fnil conj []) v))
              m1  m2))
    {}
    maps))

;;把规则转成map的表示形式
(defn convert-to-map [rule]
  (
  let [conditions (clojure.string/split rule #"\^")
       conditions2 (rest (conj conditions nil))
       cnt (count conditions)
      ]
  (loop [ map {}
          i 0]
    ( if (< i cnt) (recur ( assoc map (nth conditions i) (nth conditions2 i) ) (inc i))
         map )
    )
  )
)

;(println (convert-to-map "C1^C2^C3"))


;;构建有向无环图
(defn build-directed-acyclic-graph [rules]
( let [rc (count rules)]
( loop [i 0
        mymap {}]
  (if (< i rc)
  (recur (inc i)   (merge-map mymap  (convert-to-map (nth rules i))))
  mymap
   )
  )
)
)

(println (build-directed-acyclic-graph ["C1^C2^C3","C1^C2^C4","C1^C2^C4^C5"]))