package io.nhartner.xrp.demo;

import okhttp3.HttpUrl;
import org.xrpl.xrpl4j.client.XrplClient;
import org.xrpl.xrpl4j.client.faucet.FaucetClient;
import org.xrpl.xrpl4j.client.faucet.FundAccountRequest;
import org.xrpl.xrpl4j.model.transactions.Address;
import org.xrpl.xrpl4j.wallet.DefaultWalletFactory;
import org.xrpl.xrpl4j.wallet.Wallet;

public class FundAccount {

  private static final HttpUrl FAUCET_URL = HttpUrl.parse("https://faucet.altnet.rippletest.net");

  public static void main(String[] args) {
    FaucetClient.construct(FAUCET_URL)
        .fundAccount(FundAccountRequest.of(Address.of("rNeiLXv4JFPkTocNGhpinpurtfpxMnpzKw")));
  }

}