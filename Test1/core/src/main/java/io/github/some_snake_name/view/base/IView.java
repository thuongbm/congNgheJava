package io.github.some_snake_name.view.base;

import io.github.some_snake_name.model.base.IModel;

public interface IView {
    public void create(IModel iModel);
    public void render ();
    public void resize (int width, int height);
    public void dispose ();
    public void updateData(IModel iModel);
}
