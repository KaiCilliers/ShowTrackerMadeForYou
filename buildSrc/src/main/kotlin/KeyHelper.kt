import java.io.File
import java.io.FileInputStream
import java.util.*

object KeyHelper {

    const val TMDB_API_KEY = "tmdb_api_key"

    private val properties by lazy {
        Properties().apply {
            load(FileInputStream(File("keys.properties")))
        }
    }

    fun getValue(key: String): String {
        return properties.getProperty(key)
    }

}