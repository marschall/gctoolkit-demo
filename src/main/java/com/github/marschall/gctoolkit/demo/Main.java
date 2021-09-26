package com.github.marschall.gctoolkit.demo;

import java.nio.file.Path;
import java.util.Optional;

import com.github.marschall.gctoolkit.demo.aggregation.TotalStringDeduplicationSummary;
import com.microsoft.gctoolkit.GCToolKit;
import com.microsoft.gctoolkit.io.GCLogFile;
import com.microsoft.gctoolkit.io.SingleGCLogFile;
import com.microsoft.gctoolkit.jvm.JavaVirtualMachine;

public class Main {

  public static void main(String[] args) {
    GCLogFile logFile = new SingleGCLogFile(Path.of(args[0]));
    GCToolKit gcToolKit = new GCToolKit();

    gcToolKit.loadAggregationsFromServiceLoader();
    JavaVirtualMachine machine = gcToolKit.analyze(logFile);
    Optional<TotalStringDeduplicationSummary> results = machine.getAggregation(TotalStringDeduplicationSummary.class);

    if (results.isPresent()) {
      TotalStringDeduplicationSummary aggregationResult = results.get();
      System.out.println("Total amount saved: " + aggregationResult.getTotalReduction());
    } else {
      System.out.println("No aggregation found.");
    }
  }

}
