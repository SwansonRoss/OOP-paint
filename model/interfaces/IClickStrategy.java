package model.interfaces;

import model.persistence.ApplicationState;

public interface IClickStrategy {

    IClick getClickStrategy(ApplicationState appState);
}
