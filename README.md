## LearningAkka
Some code sprint when learning Akka

### Some Examples

#### Example 1: Library.
This example desceibes how to use Akka persistence, and shows how Akka work with Event-Souring and DDD.

##### How to use
*create a new library:

    {
        "name": "Computer",
        "books": [
            {
                "isbn": "9787121241536",
                "title": "大数据日知录",
                "author": "张俊林",
                "publishTime": "2014-09-01"
            },{
                "isbn": "9787115331809",
                "title": "信息简史",
                "author": "詹姆斯·格雷克 ",
                "publishTime": "2012-10-01"
            },{
                "isbn": "9787115244901",
                "title": "代码整洁之道",
                "author": "马丁 ",
                "publishTime": "2011-01-01"
            }
        ]
    }

*add some new books:

    {
        "name": "Computer",
        "books": [
            {
                "isbn": "9787111135104",
                "title": "计算机程序的构造和解释",
                "author": "Harold Abelson",
                "publishTime": "2004-02-01"
            }
        ]
    }

*borrow a book from library:

    {
        "name": "Computer",
        "isbn": "9787111135104",
        "title": "计算机程序的构造和解释",
        "by": "focusj"
    }

*return the book to library:

    {
        "name": "Computer",
        "isbn": "9787111135104",
        "by": "focusj"
    }