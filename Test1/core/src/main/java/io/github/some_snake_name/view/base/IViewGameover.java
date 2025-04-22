package io.github.some_snake_name.view.base;

import io.github.some_snake_name.model.base.IModel;

public interface IViewGameover extends IView{
    public void create(IModel iModel);
    public void updateData(IModel iModel);
}
