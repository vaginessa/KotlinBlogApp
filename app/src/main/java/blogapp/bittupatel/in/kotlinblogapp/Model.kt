package blogapp.bittupatel.`in`.kotlinblogapp


class HomeFeed(val posts: List<Post>)

class Post(val id: Int, val title_plain: String, val content: String, val date: String, val author: Author, val attachments: ArrayList<Attachments>, val categories: ArrayList<Categories>)

class Author(val name: String)

class Attachments(val url: String)

class Categories(val title: String)

class CategoryFeed(val categories: List<Category>)

class Category(val id: Int, val title: String)