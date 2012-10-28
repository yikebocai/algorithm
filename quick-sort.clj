(defn quick-sort [mylist]
  ;(println "mylist:" mylist)

  ;计算列表的长度
  (def cnt (count mylist))
  ;计算中间位置
  (def mid (if (> cnt 1) (int (/ cnt  2)) 0))
  ;(println (str "mid:" mid))

  ;如果中间位置不大于0直接返回列表
  (if (> mid 0)
      (let [mid-value (nth mylist mid)  ;取中间位置的值
            left (filter #(< % mid-value) mylist) ;获取比中间值小的集合
            right (filter #(> % mid-value) mylist)]  ;获取比中间值大的集合
      ;(println "left:" left )
      ;(println "mid-value:" mid-value)
      ;(println "right:" right)
      ;递归
      (concat (quick-sort left) [mid-value] (quick-sort right ) )
      )

      mylist
  )
)

(println "sorted:"(quick-sort  [2 5 9 10 4 22 1 8]) )
