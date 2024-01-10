/* Description: A set of Kotlin classes to represent a library system.
 * Author: Qiaoran 
 * Date Created: 2024-01-10
 */

class Book (val title: String, val author: String, var isAvailable: Boolean = true) {
    
}

class Library {
    var bookList: MutableList<Book> = mutableListOf()

    fun addBook(book: Book) {
        bookList.add(book)
    }

    fun removeBook(title: String) {
        var bookToRemove = bookList.find { it.title == title }
        
        if (bookToRemove == null) {
            println("This book is not on the list.")
        } else {
            bookList.remove(bookToRemove)
        }
    }

    fun displayAvailableBooks() {
        if (bookList.isEmpty()) {
            println("No books are available.")
        } else {
            bookList.filter { it.isAvailable }.forEach {
                println("${it.title} by ${it.author}")
            }
        }
    }

    fun borrowBook(title: String) {
        var bookToBorrow = bookList.find { it.title == title }
 
        if (bookToBorrow != null) {
            if (bookToBorrow.isAvailable) {
                bookToBorrow.isAvailable = false
            } else {
                println("This book is unavilable.")
            }
        } else {
            println("This book is not on the list.")
        }
    }

    fun getAvailableBooksCountByAuthor(author: String) {
        var bookCount = bookList.filter {it.author == author}.count()

        println("${bookCount} books by ${author}")
        }
    }


fun main() {
    val library = Library()

    val book1 = Book("1Q84", "Haruki Murakami")
    val book2 = Book("The Wind-Up Bird Chronicle", "Haruki Murakami")
    val book3 = Book("Kitchen", "Banana Yoshimoto")

    library.addBook(book1)
    library.addBook(book2)
    library.addBook(book3)
    // library.displayAvailableBooks()

    // library.removeBook("not a book")
    // library.removeBook("The Wind-Up Bird Chronicle")
    // library.displayAvailableBooks()

    // library.borrowBook("1984")
    // library.borrowBook("1Q84")
    // library.displayAvailableBooks()

    //library.getAvailableBooksCountByAuthor("Harcdsuki Murakami")
    library.getAvailableBooksCountByAuthor("Haruki Murakami")
}
