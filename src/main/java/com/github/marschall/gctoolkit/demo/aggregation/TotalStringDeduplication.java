package com.github.marschall.gctoolkit.demo.aggregation;

import com.microsoft.gctoolkit.aggregator.Aggregates;
import com.microsoft.gctoolkit.aggregator.Aggregator;
import com.microsoft.gctoolkit.aggregator.EventSource;
import com.microsoft.gctoolkit.event.g1gc.G1ConcurrentStringDeduplication;

@Aggregates(EventSource.G1GC)
public class TotalStringDeduplication extends Aggregator<TotalStringDeduplicationAggregation> {

  public TotalStringDeduplication(TotalStringDeduplicationAggregation results) {
    super(results);
    this.register(G1ConcurrentStringDeduplication.class, this::extractStringReduction);
  }

  private void extractStringReduction(G1ConcurrentStringDeduplication event) {
    this.aggregation().addReduction(event.getReduction());
  }

}
