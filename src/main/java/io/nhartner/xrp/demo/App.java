package io.nhartner.xrp.demo;

import java.util.stream.IntStream;
import java.util.stream.Stream;
import org.xrpl.xrpl4j.wallet.DefaultWalletFactory;
import org.xrpl.xrpl4j.wallet.SeedWalletGenerationResult;
import org.xrpl.xrpl4j.wallet.Wallet;
import org.xrpl.xrpl4j.wallet.WalletFactory;

public class App {

  private static WalletFactory walletFactory = DefaultWalletFactory.getInstance();

  public static void main(String[] args) {
    while(true) {
      IntStream.range(0, 10000)
          .parallel()
          .mapToObj($ -> walletFactory.randomWallet(true))
          .filter(result -> isVanity(result.wallet(), "Bob", "Bar", "Doge"))
          .forEach(App::print);
    }
  }

  public static boolean isVanity(Wallet wallet, String...prefixes) {
    return Stream.of(prefixes)
        .anyMatch(prefix -> wallet.classicAddress().value().startsWith("r" + prefix));
  }


  public static void print(SeedWalletGenerationResult result) {
    System.out.printf("address: %s, seed: %s\n", result.wallet().classicAddress(), result.seed());
  }

}