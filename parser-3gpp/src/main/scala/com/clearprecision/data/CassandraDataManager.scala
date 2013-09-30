package com.clearprecision.data

import com.datastax.driver.core.Cluster
import scala.collection.JavaConversions._
import com.datastax.driver.core.Session
import com.clearprecision.parser.jaxb._

/**
 * This implementation of the DataOperations trait is used for saving 3GPP XML data into a Cassandra data store.
 */
class CassandraDataManager(node: String) extends DataOperations {

  /**
   * Write the values of specific data object to the Cassandra store.
   * @param data MeasCollecFile
   */
  def save(data: MeasCollecFile) = {
    val connection = CassandraDataManager.connect(node)

    connection.foreach(session => {
      try {
        session.execute(" insert into schema1.measdata (id, vendorName, dnPrefix) values (now(), '"
          + data.getFileHeader.getVendorName + "', '" + data.getFileHeader.getDnPrefix + "');")
      } finally {
        CassandraDataManager.close(session);
      }
    })
  }

}

/**
 * Companion object for CassandraDataManager.
 * Manages connections to the data store.
 */
object CassandraDataManager {

  /**
   * Connects to the specified Cassandra node
   * Returns the connection wrapped in an Option type
   *
   * @return Option
   */
  def connect(node: String): Option[Session] = {
    val cluster = Cluster.builder()
      .addContactPoint(node).build();

    val metadata = cluster.getMetadata();
    printf("Connected to cluster: %s\n", metadata.getClusterName);

    val hosts = metadata.getAllHosts()
    hosts.foreach(host => printf("Datatacenter: %s; Host: %s; Rack: %s\n",
      host.getDatacenter, host.getAddress, host.getRack))

    Some(cluster.connect())
  }

  /**
   * Closes a cassandra session
   */
  def close(session: Session) = {
    session.getCluster().shutdown()
  }

}
   
   