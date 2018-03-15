package playground.erp.melontech.com.architecurepuzzle

import android.arch.persistence.room.*


/**
 * Created by vmanev on 2/23/2018.
 */
@Entity
class User{
    @PrimaryKey
    public var uid: Int = 0

    @ColumnInfo(name = "first_name")
    public var firstName: String? = null

    @ColumnInfo(name = "last_name")
    public var lastName: String? = null

}

@Dao
interface UserDao {
    @get:Query("SELECT * FROM user")
    val all: List<User>

    @Query("SELECT * FROM user WHERE uid IN (:userIds)")
    fun loadAllByIds(userIds: IntArray): List<User>

    @Query("SELECT * FROM user WHERE first_name LIKE :first AND " + "last_name LIKE :last LIMIT 1")
    fun findByName(first: String, last: String): User

    @Insert
    fun insertAll(vararg userViewModels: User)

    @Delete
    fun delete(user: User)
}