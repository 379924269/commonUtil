## 一些工具类的集合

### 1、code-generater
主要是用来生成简单的mybaits的代码的。

### 2、export-xls-doc-pdf
excel的一些操作，如导入、导出等

### 3、simple-mybaits-plus
简单的实现了对一个数据库的curd操作，通过代码自动生成器生成代码。
我用它主要是生成测试数据。避免手动生成麻烦

### 4、dboperate 主要用来权限sql避免手动操作

#### 遇到的一些问题：
````
LocalDateTime：直接插入的时候直接插入LocalDateTime.now() 就可以了