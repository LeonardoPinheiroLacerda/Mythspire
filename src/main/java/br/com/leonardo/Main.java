package br.com.leonardo;

import br.com.leonardo.rendering.Scene;
import br.com.leonardo.rendering.Stage;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Main {

    public static void main(String[] args) {


        System.out.println("""
                    __  ___      __  __               _        \s
                   /  |/  /_  __/ /_/ /_  _________  (_)_______\s
                  / /|_/ / / / / __/ __ \\/ ___/ __ \\/ / ___/ _ \\
                 / /  / / /_/ / /_/ / / (__  ) /_/ / / /  /  __/
                /_/  /_/\\__, /\\__/_/ /_/____/ .___/_/_/   \\___/\s
                       /____/              /_/                 \s
                       """);

        Stage stage = new Stage("2D Adventure");
        Scene scene = new Scene();
        stage.setScene(scene);
        stage.start();


    }
}
