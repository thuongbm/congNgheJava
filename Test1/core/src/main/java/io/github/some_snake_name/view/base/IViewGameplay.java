package io.github.some_snake_name.view.base;

import io.github.some_snake_name.model.base.IModel;

public interface IViewGameplay extends IView{
    public void create(IModel iModel);
    public void updateData(IModel iModel);
    public void pause();
}
