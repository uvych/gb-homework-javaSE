package com.geekbrains.georgy.lesson12.repo;

import com.geekbrains.georgy.lesson12.annotation.DbColumn;
import com.geekbrains.georgy.lesson12.annotation.DbTable;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ReflectionRepository<T> {
    private static Connection connection;
    private static Statement statement;
    private final Class<T> myClass;
    private static String title;


    public ReflectionRepository(Class<T> myClass) {
        this.myClass = myClass;
        try {
            connect();
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
            disconnect();
        }
        title = this.myClass.getAnnotation(DbTable.class).title();
    }

    public void InsertToDB(T object){
        try (PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO "+ title +" (brand, type) VALUES (? , ?);")){
            String [] data = getDataObject(myClass,object);
            connection.setAutoCommit(false);
            preparedStatement.setString(1, data[0]);
            preparedStatement.setString(2, data[1]);
            connection.setAutoCommit(true);
        } catch (IllegalAccessException | SQLException e) {
            e.printStackTrace();
            disconnect();
        }
    }

    public void clearTableEx() throws SQLException {
            statement.executeUpdate("DELETE FROM " +  title +";");
    }

    public void deleteById(Long id) throws SQLException {
        statement.executeUpdate("DELETE FROM " + title + " WHERE id = " + id +";");
    }

    public T readToDbById (Long id) throws Exception {
        try (ResultSet rs = statement.executeQuery("SELECT * FROM "+ title +" WHERE id = " + id + ";")) {
            T obj = myClass.getConstructor().newInstance();
            while (rs.next()) {
                save(obj,rs);
            }
            return obj;
        }
    }

    public List<T> readAll () throws Exception {
        try (ResultSet rs = statement.executeQuery("SELECT * FROM "+ title +";")) {
            ArrayList<T> list = new ArrayList<>();
            while (rs.next()) {
                T obj = myClass.getConstructor().newInstance();
                save(obj, rs);
                list.add(obj);
            }
            return list;
        }
    }

    private void save(T obj , ResultSet rs) {
        try {
            Method methodType =  myClass.getMethod("setType", String.class);
            Method methodBrand = myClass.getMethod("setBrand", String.class);
            Method methodId = myClass.getMethod("setId", Long.class);

            methodType.invoke(obj, rs.getString(3));
            methodBrand.invoke(obj, rs.getString(2));
            methodId.invoke(obj, rs.getLong(1));
        } catch (NoSuchMethodException | IllegalAccessException | SQLException | InvocationTargetException e) {
            e.printStackTrace();
        }

    }

    private String [] getDataObject(Class<T> tClass, T object) throws  IllegalAccessException {
        String [] data = new String[2];

        Field [] fields = tClass.getDeclaredFields();
        for (Field field : fields){
            if (field.isAnnotationPresent(DbColumn.class) && field.getName().equals("brand")) {
                field.setAccessible(true);
                data[0] = field.get(object).toString();
            }
            if (field.isAnnotationPresent(DbColumn.class) && field.getName().equals("type")) {
                field.setAccessible(true);
                data[1] = field.get(object).toString();
            }
        }
        return data;
    }



    private static void connect() throws ClassNotFoundException, SQLException {
        Class.forName("org.sqlite.JDBC");
        connection = DriverManager.getConnection("jdbc:sqlite:Transport.db");
        statement = connection.createStatement();
    }

    private static void disconnect() {
        try {
            if (statement != null) {
                statement.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        try {
            if (connection != null) {
                connection.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
