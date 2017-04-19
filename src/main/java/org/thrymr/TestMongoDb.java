/**
 * 
 */
package org.thrymr;

import com.mongodb.DBCursor;

/**
 * @author thrymr
 *
 */
public class TestMongoDb {

    public static void main(String[] args) {

        DBCursor result = MongoContext.get().connectDb("test").findByKey("Employee", "age", 23, (value) -> new Integer(value));

        while (result.hasNext()) {

            System.out.println(result.next());

        }

    }
}
