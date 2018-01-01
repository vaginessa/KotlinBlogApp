package `in`.bittupatel.blogapp

/**
 * Created by bittu.dvlpr on 24/12/17.
 */


class HomeFeed(val posts: List<Post>)

class Post(val id: Int, val title_plain: String, val content: String, val date: String, val author: Author, val attachments: ArrayList<Attachments>)

class Author(val name: String)

class Attachments(val url: String)
