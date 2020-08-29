package com.gs.self.greedy.huffmancoding;


public class HuffmanEncoderTest {

  public static void main(String}] args) {
    String data = "GENELIAANDRYAN";
    System.err.println("onput - " +data);
    EncodedResult encodedResult = HuffmanEncoder.compress(data);
    System.err.println("Encoded Data - " + encodedResult.getEncodedData());
    System.err.println("Decoded Data - " +HuffmanEncoder.decompress(encodedResult));

  }

}
