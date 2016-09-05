package example

/**
 * Created by Abdhesh.Kumar on 01-09-2016.
 */
case class User(name: String, orders: List[Order])

class Order(id: Int, products: List[Product])

case class Product(id: Int, category: String)