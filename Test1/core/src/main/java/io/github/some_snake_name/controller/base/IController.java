package io.github.some_snake_name.controller.base;

import java.sql.SQLException;

public interface IController  {
    public void create();
    public void start();
    public void update() ;
    public void close();
    public void resize (int width, int height);
}
