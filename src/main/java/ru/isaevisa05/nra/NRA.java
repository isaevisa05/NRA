package ru.isaevisa05.nra;

import ru.isaevisa05.nra.components.ServerConstructor;
import ru.isaevisa05.nra.components.enums.ServerType;

public class NRA {
    public static void main(String[] args) {
        

        ServerConstructor.construct(ServerType.TCP_TUNNEL);
    }
}
