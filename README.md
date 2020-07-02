# Beat-Google-group3
◎Introduction
-------
Topic : 衣服、飾品網拍

Motivation: 
When we type “網拍" in Google searching engine, we usually get the webpage of the blogs recommending a lot of “網拍". However, the people who type "網拍" in the searching engine actually want to get the direct websites that sell clothing, accessories and so on but not the sharing experience.


```diff
-  Keyword（依重要程度 大～小排序）:
退貨
熱門商品/熱銷/Hot Sales
購物車
新品/New Arrival
購買說明/How to buy
訂單查詢
關於我們
優惠/Sales
```

◎ Features of System
-------
1. Target User : 
 For anyone who tends to use search engine to find the ideal  shopping platforms.

2. Funtions of System :
By calculating the score of webpages, the system helps to identify the importance of each website and also rank them by score.
 (score = Σ the keyword’s weight x appearence time in website’s HTML)

3. How to Use :
Just input the keywords which meet the need.


◎ Challenges /Techniques that you need but may have a hard time to learn on your own
-------

Our project topic is to enable people who loved shopping online to get the correct webpage according their request and we focused on clothes and accessories. There were many discount event provided by the E-commerce in holiday. If we can push our default keywordList into database, we could adjust the keyword to make the request more precise. Last but not least, we could finally narrow the range and only websites which provide holiday discount would be available for users.
Current obstacle: First of all, We don’t know how to make our project connect to google searching engine. Secondly, we try to put the numbers of picture into the ranking process, but we aren’t familiar with HTML. It’s difficult for us to implement the function into our project. 



◎ User Interface
-------
1. First page: The user will be asked to enter keyword on the blank. Ex: 雨傘、韓國網拍

2. Second page: After the user enter keyword, the results will be displayed on page depending on its rank.
