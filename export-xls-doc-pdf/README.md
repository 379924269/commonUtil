## 导出excel、pdf、word....,他们的代码基本上差不多，可以模仿者写（具体参考）下面git上的demo

## 可以参考：ireport 的简单介绍(上面也有下载地址，可以自己下载)
http://www.cnblogs.com/mingforyou/p/4568521.html
    
## jasperreport在git上的demo：
https://github.com/Jaspersoft/jasperreports/blob/6.4.1.x/jasperreports/demo/samples

## 问题：
* 1、生成pdf的时候报错：这个jar包要手动加进去，我找了几个库都没看到这个文件，itext-asian-5.1.1.jar这个jar永不起，感觉类容是一样的。
<br>net.sf.jasperreports.engine.JRRuntimeException: Could not load the following font :
<br>pdfFontName : STSong-Light
<br>pdfEncoding : UniGB-UCS2-H
<br>isPdfEmbedded : false
<br>出现上述错误提示加入
<br>iTextAsian.jar