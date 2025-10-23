for(int a = 0; a<countDriver-1; a++){
                    for(int b =  a + 1; b<countDriver; b++){
                        if (dataDriver[a][0] != null && dataDriver[b][0] != null) {
                            if(dataDriver[a][0].compareToIgnoreCase(dataDriver[b][0])> 0){
                                // tukar nama
                                String tempDriver = dataDriver[a][0];
                                dataDriver[a][0] = dataDriver [b][0];
                                dataDriver[b][0] = tempDriver;
                                // tukar x
                                String tempX = dataDriver[a][1];
                                dataDriver[a][1] = dataDriver [b][1];
                                dataDriver[b][1] = tempX;
                                // tukar y
                                String tempY = dataDriver[a][2];
                                dataDriver[a][2] = dataDriver [b][2];
                                dataDriver[b][2] = tempY;
                            }
                        }
                    }
                }
                    for(int print = 0; print<countDriver; print++){
                    if (dataDriver[print][0] != null)
                    System.out.println(dataDriver[print][0] + " @ " + dataDriver[print][1] + ", " + dataDriver[print][2]);
                }