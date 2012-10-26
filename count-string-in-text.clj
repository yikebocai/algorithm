;;统计一段文本中出现某个字符串的次数
(defn count-string-in-text [str txt]
  ( loop [t txt
          cnt 0]   ;计数器
    (if (.contains t str) ;判断字符串是否包含在文本中
        (recur
          (subs t        ;取第一次命中位置后的文本内容
            (+ (.indexOf t str) (.length str))   ;下一次要匹配的剩余文本内容
            (.length t)) ;文本总长度
          (inc cnt))     ;匹配一次加1
       cnt  )
    ))

(print (str "count string in text:"
         (count-string-in-text "abc" "helo,abc,workabcefabcllll")   ))