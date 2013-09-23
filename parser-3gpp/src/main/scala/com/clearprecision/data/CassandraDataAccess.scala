package com.clearprecision.data

import com.datastax.driver.core.Cluster
import scala.collection.JavaConversions._
import com.datastax.driver.core.Session
import com.clearprecision.parser.jaxb._

class CassandraDataAccess(node: String) extends DataOperations {

  def save(data: MeasCollecFile) = {
    val session = CassandraDataAccess.connect(node)

    session.execute(" insert into measdata (id, vendorName, dnPrefix) values (now(), '"
      + data.getFileHeader.getVendorName + "', '" + data.getFileHeader.getDnPrefix + "');")
      
    CassandraDataAccess.close(session);
  }

  def load(data: MeasCollecFile) = {

  }

}

object CassandraDataAccess {

  def connect(node: String): Session = {
    val cluster = Cluster.builder()
      .addContactPoint(node).build();

    val metadata = cluster.getMetadata();
    printf("Connected to cluster: %s\n", metadata.getClusterName);

    val hosts = metadata.getAllHosts()
    hosts.foreach(host => printf("Datatacenter: %s; Host: %s; Rack: %s\n",
      host.getDatacenter, host.getAddress, host.getRack))

    cluster.connect()
  }

  def close(session: Session) = {
    session.getCluster().shutdown()
  }

}
   
   