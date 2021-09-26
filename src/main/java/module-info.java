import com.github.marschall.gctoolkit.demo.aggregation.TotalStringDeduplicationSummary;
import com.microsoft.gctoolkit.aggregator.Aggregation;

/**
 * Contains an Aggregator and an Aggregation
 */
module com.github.marschall.gctoolkit.demo {
    requires com.microsoft.gctoolkit.api;
    requires com.microsoft.gctoolkit.vertx;
    requires java.logging;

    exports com.github.marschall.gctoolkit.demo.aggregation to com.microsoft.gctoolkit.vertx;

    provides Aggregation with TotalStringDeduplicationSummary;
}