package io.github.some_snake_name.model.base;

import io.github.some_snake_name.model.SnakeModel;
import io.github.some_snake_name.model.WorldModel;

public interface IModel {
    public void update(float delta);
    public WorldModel getWorldModel();
}
