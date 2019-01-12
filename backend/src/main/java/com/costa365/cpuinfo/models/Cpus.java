package com.costa365.cpuinfo.models;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;

public class Cpus {
  @Id
  private ObjectId _id;

  private String name;
  private String cores;
  private String type;
  private Integer cpuMark;
  private Integer singleThreadMark;
  private Integer tdp;
  private Integer powerPerf;
  private String releaseDate;
  
  public Cpus() {}
  
  public Cpus(ObjectId _id, String name, String cores, String type, Integer cpuMark, 
            Integer singleThreadMark, Integer tdp, Integer powerPerf, String releaseDate) {
    this._id = _id;
    this.name = name;
    this.cores = cores;
    this.type = type;
    this.cpuMark = cpuMark;
    this.singleThreadMark = singleThreadMark;
    this.tdp = tdp;
    this.powerPerf = powerPerf;
    this.releaseDate = releaseDate;
  }

  public String getId() { 
    return this._id.toHexString(); 
  }
  
  public void setId(ObjectId _id) { 
    this._id = _id; 
  }

  public String getName() { 
    return this.name; 

  }

  public void setName(String name) { 
    this.name = name; 
  }

  public String getCores() { 
    return this.cores; 
  }

  public void setCores(String cores) { 
    this.cores = cores; 
  }

  public String getType() { 
    return this.type; 
  }

  public void setType(String type) { 
    this.type = type; 
  }

  public Integer getCpuMark() { 
    return this.cpuMark; 
  }

  public void setCpuMark(Integer cpuMark) { 
    this.cpuMark = cpuMark; 
  }

  public Integer getSingleThreadMark() { 
    return this.singleThreadMark; 
  }

  public void setSingleThreadMark(Integer singleThreadMark) { 
    this.singleThreadMark = singleThreadMark; 
  }

  public Integer getTdp() { 
    return this.tdp; 
  }

  public void setTdp(Integer tdp) { 
    this.tdp = tdp;
  }

  public Integer getPowerPerf() { 
    return this.powerPerf; 
  }

  public void setPowerPerf(Integer powerPerf) { 
    this.powerPerf = powerPerf; 
  }

  public String getReleaseDate() { 
    return this.releaseDate; 
  }

  public void setReleaseDate(String releaseDate) { 
    this.releaseDate = releaseDate; 
  }
}
