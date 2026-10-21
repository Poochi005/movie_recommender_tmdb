import mysql.connector

connection = mysql.connector.connect(
    host="localhost",
    port=3306,
    user="root",
    password="NewPass@2005",
    database="movie_tmdb_db"
)

cursor = connection.cursor()

# Your already tested working Four Rooms poster
placeholder = "/75aHn1NOYXh4M7L5shoeQ6NGykP.jpg"

cursor.execute("""
    UPDATE tmdb_movies
    SET poster_path = %s
    WHERE poster_path IS NULL
       OR poster_path = ''
""", (placeholder,))

updated = cursor.rowcount

connection.commit()

cursor.close()
connection.close()

print()
print("==============================")
print("PLACEHOLDER POSTERS COMPLETED")
print("==============================")
print(f"Movies updated : {updated}")