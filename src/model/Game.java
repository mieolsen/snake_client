package model;

import java.sql.Date;

/**
 * Created by Peter on 12-10-2015.
 */

public class Game {
    //Creating the variables needed for the game
    private int gameId;
    private Gamer winner;
    private String name;
    private String hostControls;
    private Gamer host;
    private Gamer opponent;
    private String opponentControls;
    private String status;
    private Date created;
    private int mapSize;

    //Creating the constructor and initiating the variables
    public Game(int gameId, Gamer winner, String hostControls, Date created, String name, Gamer host, Gamer
            opponent, String status, int mapSize){
        this.mapSize = mapSize;
        this.gameId = gameId;
        this.winner = winner;
        this.created = created;
        this.hostControls = hostControls;
        this.name = name;
        this.host = host;
        this.opponent = opponent;
        this.status = status;
    }

    public Game(){}

    public Date getCreated() {
        return created;
    }

    public void setCreated(Date created) {
        this.created = created;
    }

    public int getMapSize() {
        return mapSize;
    }

    public void setMapSize(int mapSize) {
        this.mapSize = mapSize;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    //methods that the API can use
    public User getResultForGame(){
        return winner;
    }

    public User getWinner() {
        return winner;
    }

    public void setWinner(Gamer winner) {
        this.winner = winner;
    }

    public void validate(){    }

    //Creating get/set method for all the variables, so they can be used by other classes
    public int getGameId(){
        return gameId;
    }

    public void setGameId(int gameId){
        this.gameId = gameId;
    }

    public String getHostControls() {
        return hostControls;
    }

    public void setHostControls(String controls) {
        this.hostControls = controls;
    }

    public Gamer getHost(){
        return host;
    }

    public void setHost(Gamer host){
        this.host = host;
    }

    public Gamer getOpponent(){
        return opponent;
    }

    public void setOpponent(Gamer opponent){
        this.opponent = opponent;
    }

    public String getStatus(){
        return status;
    }

    public void setStatus(String status){
        this.status = status;
    }

    public String getOpponentControls() {
        return opponentControls;
    }

    public void setOpponentControls(String opponentControls) {
        this.opponentControls = opponentControls;
    }
} //end of class
