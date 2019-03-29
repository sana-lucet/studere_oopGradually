package model.player;

import model.card.Card;

import java.util.ArrayList;

public abstract class Player {
    public void hit(){
        this._hit();
    }
    public void emptyHands(){
        this._emptyHands();
    }
    public void debugPrint(){
        this._debugPrint();
    }
    public int totalPoints(){
        return this._totalPoints();
    }
    public ArrayList<Card> getHand(){
        return this._getHand();
    }

    abstract void _emptyHands();
    abstract void _hit();
    abstract void _debugPrint();
    abstract int _totalPoints();
    abstract ArrayList<Card> _getHand();
}
