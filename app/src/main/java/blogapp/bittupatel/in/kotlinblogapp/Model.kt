package blogapp.bittupatel.`in`.kotlinblogapp

// Post Model
class Post(var id: Int, var title_plain: String, var content: String, var date: String, var author: String, var thumbnail_images: String)

//Category Model
class Category(var id: Int, var title: String)

//Favourite Model
class FavPost {
    var id: Int = 0
    lateinit var title: String
    lateinit var date: String
    lateinit var author: String
    lateinit var thumbnail: String
    lateinit var content: String
}