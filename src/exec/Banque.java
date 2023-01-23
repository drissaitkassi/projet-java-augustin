package exec;


import java.util.Scanner;

public class Banque {

    private static boolean isActive = true;

    private static int choix = 1;

    public static void main(String[] args) {

        menu();
        while (isActive) {

            int n = userInputint();

            if (n != 6) {

                switch (n) {
                    case 9 -> menu();
                    case 1 -> {
                        System.out.println("vous voulez verser combien ?:");
                        // verser(userInputint());
                    }
                    case 2 -> {
                        System.out.println("vous voulez retirer combien ?:");
                        //retirer(userInputint());
                    }
                    case 3 -> {
                        System.out.println("votre sold est :");
                        //sold();
                    }
                    case 4 -> {
                        System.out.println("votre mini relevee ");
                        // miniReleve();
                    }
                    case 5 -> {
                        System.out.println("votre conseillé est :");
                        monConseille();
                    }
                }
            } else {
                isActive = false;
            }
            System.out.println("voulez vous continuer ? si oui tapez 1 si non tapez 6");

            choix = userInputint();
            if (choix == 1) {
                System.out.println("choissisez un service SVP");
                isActive = true;
            } else if (choix == 6) {
                System.out.println("||==========================||");
                System.out.println("||   vous avez quitter      ||");
                System.out.println("||        le menu           ||");
                System.out.println("||                          ||");
                System.out.println("||   au plaisir de vous     ||");
                System.out.println("||        Revoir            ||");
                System.out.println("||                          ||");
                System.out.println("||                          ||");
                System.out.println("||==========================||");
                isActive = false;
            }

        }


    }

    private static int userInputint() {
        Scanner scanner = new Scanner(System.in);
        return scanner.nextInt();
    }

    private static int userInputstr() {
        Scanner scanner = new Scanner(System.in);
        return scanner.nextLine().charAt(0);
    }


    public static void menu() {
        String banner = """
                                                                                                                                                                      \s
                @@@@@@@   @@@  @@@@@@@@  @@@  @@@  @@@  @@@  @@@@@@@@  @@@  @@@  @@@  @@@      @@@@@@      @@@       @@@  @@@@@@@@  @@@@@@@@  @@@@@@@   @@@@@@@@  @@@ \s
                @@@@@@@@  @@@  @@@@@@@@  @@@@ @@@  @@@  @@@  @@@@@@@@  @@@@ @@@  @@@  @@@     @@@@@@@@     @@@        @@  @@@@@@@@  @@@@@@@@  @@@@@@@@  @@@@@@@@  @@@ \s
                @@!  @@@  @@!  @@!       @@!@!@@@  @@!  @@@  @@!       @@!@!@@@  @@!  @@@     @@!  @@@     @@!       @!   @@!       @@!       @@!  @@@  @@!       @@! \s
                !@   @!@  !@!  !@!       !@!!@!@!  !@!  @!@  !@!       !@!!@!@!  !@!  @!@     !@!  @!@     !@!            !@!       !@!       !@!  @!@  !@!       !@! \s
                @!@!@!@   !!@  @!!!:!    @!@ !!@!  @!@  !@!  @!!!:!    @!@ !!@!  @!@  !@!     @!@!@!@!     @!!            @!!!:!    @!!!:!    @!@!!@!   @!!!:!    !!@ \s
                !!!@!!!!  !!!  !!!!!:    !@!  !!!  !@!  !!!  !!!!!:    !@!  !!!  !@!  !!!     !!!@!!!!     !!!            !!!!!:    !!!!!:    !!@!@!    !!!!!:    !!! \s
                !!:  !!!  !!:  !!:       !!:  !!!  :!:  !!:  !!:       !!:  !!!  !!:  !!!     !!:  !!!     !!:            !!:       !!:       !!: :!!   !!:       !!: \s
                :!:  !:!  :!:  :!:       :!:  !:!   ::!!:!   :!:       :!:  !:!  :!:  !:!     :!:  !:!      :!:           :!:       :!:       :!:  !:!  :!:       :!: \s
                 :: ::::   ::   :: ::::   ::   ::    ::::     :: ::::   ::   ::  ::::: ::     ::   :::      :: ::::        :: ::::   ::       ::   :::   :: ::::   :: \s
                :: : ::   :    : :: ::   ::    :      :      : :: ::   ::    :    : :  :       :   : :     : :: : :       : :: ::    :         :   : :  : :: ::   :   \s
                                                                                                                                                                      \s
                """;

        System.out.println(banner);
        System.out.println();
        System.out.println("||==================================||");
        System.out.println("||   Menu Principale                ||");
        System.out.println("||                                  ||");
        System.out.println("|| 1-afficher tous les programmeurs ||");
        System.out.println("|| 2-afficher un  programmeur       ||");
        System.out.println("|| 3-subprime un  programmeur       ||");
        System.out.println("|| 4-afficher un  programmer        ||");
        System.out.println("|| 5-modifier le salaire            ||");
        System.out.println("|| 6-Quitter le programme           ||");
        System.out.println("|| 7-voir mon conseiller            ||");
        System.out.println("|| 9-Afficher le Menu Principale    ||");
        System.out.println("||                                  ||");
        System.out.println("||==================================||");
    }


    public static void monConseille() {

        System.out.println("Mr Driss ait Kassi");
        System.out.println("Me Contacter Par Email : driss.aitkassi@efrei.net");
        System.out.println("Me contacter par Telephone: +212-65 555 666");
        System.out.println();
        String imageProfile = """
                000110%0111111111111111;:,,::;110000000000%00000000011S
                011110%011111111111111, ......,;0000000000%00000000011S
                011110%01111111111111,.,,:,:,,.,;000000000%00000000111S
                111111%0111111111111:.;100000011;100000000000000000010#
                111111%0111111111111,.:11000000%;10000001100%%%%%%0000#
                111111%0111111111111:.:;;;111;;;11000%%000%0%%%%%%0000#
                111111%01;0111111111:::,,,,:,,,;1;00%%%000%0%%%%%%000%#
                1111;;%01;1111111111;:;;;;:11;;100%%%%%000%0%%%%%%000%#
                1111;;000;11111111111;;;;;;101110000%%%00100%%%%%%000S#
                1111;;000;11111111111;;;;;;;;111000000000000%%0000000%#
                1111;;1%0;111111111111::;::;;1;110%%%%%%%%%000000111100
                1111;;100111111111;;:,.:,::;;;;1:;110%%%%%%%%%%%%01110%
                1;;;;;;00;;11111;,,,,,.::,,::;1;::,::;10%SSS%%%%%%000S#
                ;;;;;;;001;1;:::,,,,,,,.:;;;1;:,::,::,,:;;1%SS%%%%000S#
                ;;;;;;;101;::,,:,,:,,,...,,:,,,,::,,::,,:,::1%%%%%000S#
                ;;;;;;;10;::::,:,,,,:,,.. .......,::,:,,:,:::1%SS%%0%#S
                ;;;;;;;;;::,:,,:,,,,,,,,,..,,,,,,:::,,,,:,:,::1%%%00%SS
                ;;;;;;;:::,,,,,,,,,,,,,,,..,,:,:,::::::,:,,,,,:101000%%
                ;;;;;;::,:,,,,,,,,,,,:,,...,,:::,,,:,,,,,.,,,,,;1;110%%
                ;;;;;;:,,,,,,..,,,,:,,,,,..,,,::::,,,,,....,,,,:;;110%0
                ;;;;;::,,,,,,..,,,,:,:,:,...,,,:::,,,,,.....,,,,:;;;100
                ;;;;:,,:,,,,....,,,,,:,,....,:,,,:,:,,,,. ..,,,,:;;;;;;
                ;;;:::,:,,,.,. ..,,,,,,,,...,:,:,,,,,,,.. ..,,,,,:;1111
                ;;:::,,,:,,.:. ....,.,,,.,:::,.,.,.,,,,:,,....,,,,11111
                ;;:,,,:,,,,:;. .............,.........,;,:...,,,,,:1111
                """;

        System.out.println(imageProfile);


    }

}