package aedalert.net;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.apache.tools.ant.types.LogLevel;
import org.json.JSONArray;
import org.json.JSONObject;


public class RetrieveData {
	private static final Logger log = Logger.getLogger(RetrieveData.class.getName());

	/**
	 * sending a spark msg
	 * @param sUrl
	 * @param text
	 * @param email
	 * @throws IOException
	 * @throws HttpResponseCodeException
	 */
	public static void sendSpark(String sUrl, String text, String email) 
			throws IOException, HttpResponseCodeException {
		try {
	        URL url = new URL(sUrl);
	        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
	        connection.setRequestProperty("Authorization", "Bearer NTNkZTAwNzAtNDY0ZS00YzE2LTliMzktNGQ5ZmYwYWVmY2VhYTI5Y2E1ZjUtODdh");
	        connection.setRequestProperty("Content-Type", "application/json");
	 
	        // POST the http body data
	        connection.setDoOutput(true);
	        connection.setRequestMethod("POST");
	        OutputStreamWriter writer = new OutputStreamWriter(connection.getOutputStream());
	        String data = "{\"toPersonEmail\": \"{toPersonEmail}\", \"text\": \"{text}\"}";
	        data = data.replace("{toPersonEmail}", email);
	        data = data.replace("{text}", text);
	        writer.write(data);
	        writer.close();
	 
	        if (connection.getResponseCode() == HttpURLConnection.HTTP_OK) {
	            // OK
	            BufferedReader reader = new BufferedReader(new InputStreamReader(url.openStream()));
	            StringBuffer res = new StringBuffer(); 
	            String line;
	            while ((line = reader.readLine()) != null) {
	                res.append(line);
	            }
	            reader.close();
	 
	        } else {
	            // Server returned HTTP error code.
	        	BufferedReader reader = new BufferedReader(new InputStreamReader(url.openStream()));
	            StringBuffer res = new StringBuffer(); 
	            String line;
	            while ((line = reader.readLine()) != null) {
	                res.append(line);
	            }
	            reader.close();
	            log.log(Level.WARNING, "result: " + res.toString());
	            log.log(Level.WARNING, "error creating a message in spark.");
	        	throw new HttpResponseCodeException(connection.getResponseCode(), connection.getResponseMessage());
	        }
	 
		} catch (MalformedURLException ex) {
			log.log(Level.WARNING, "malformed url.  this should not happen as the input should have be vetted", ex);
		}
//	    } catch (Exception e) {
//	    	return null;
//	    }
		
		
	}
	
	/**
	 * call ingenu board
	 * @param sUrl
	 * @param text
	 * @param email
	 * @throws IOException
	 * @throws HttpResponseCodeException
	 */
	public static void callIngenu(String sUrl) 
			throws IOException, HttpResponseCodeException {
		try {
	        URL url = new URL(sUrl);
	        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
	        connection.setRequestProperty("Authorization", "248c341e-997e-48b1-9b9b-e38d2bd0170a");
	        connection.setRequestProperty("Content-Type", "application/xml");
	        connection.setRequestProperty("Accept", "application/xml");
	 
	        // POST the http body data
	        connection.setDoOutput(true);
	        connection.setRequestMethod("POST");
	        OutputStreamWriter writer = new OutputStreamWriter(connection.getOutputStream());
	        String data = "<downlink xmlns='http://www.ingenu.com/data/v1/schema'><datagramDownlinkRequest><tag>11112223-04d3-4a21-a8e4-148130b5484c</tag><nodeId>0x32a0f</nodeId><payload>0301870010</payload></datagramDownlinkRequest></downlink>";
	        writer.write(data);
	        writer.close();
	 
	        if (connection.getResponseCode() == HttpURLConnection.HTTP_OK) {
	            // OK
	            BufferedReader reader = new BufferedReader(new InputStreamReader(url.openStream()));
	            StringBuffer res = new StringBuffer(); 
	            String line;
	            while ((line = reader.readLine()) != null) {
	                res.append(line);
	            }
	            reader.close();
	 
	        } else {
	            // Server returned HTTP error code.
	        	BufferedReader reader = new BufferedReader(new InputStreamReader(url.openStream()));
	            StringBuffer res = new StringBuffer(); 
	            String line;
	            while ((line = reader.readLine()) != null) {
	                res.append(line);
	            }
	            reader.close();
	            log.log(Level.WARNING, "result: " + res.toString());
	            log.log(Level.WARNING, "error creating a message in spark.");
	        	throw new HttpResponseCodeException(connection.getResponseCode(), connection.getResponseMessage());
	        }
	 
		} catch (MalformedURLException ex) {
			log.log(Level.WARNING, "malformed url.  this should not happen as the input should have be vetted", ex);
		}
//	    } catch (Exception e) {
//	    	return null;
//	    }
		
		
	}
	
	public static JSONObject postJson(String sUrl) 
			throws IOException, HttpResponseCodeException {
		JSONObject json = null;
		try {
	        URL url = new URL(sUrl);
	        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
	        connection.setRequestProperty("Authorization", "Bearer NTNkZTAwNzAtNDY0ZS00YzE2LTliMzktNGQ5ZmYwYWVmY2VhYTI5Y2E1ZjUtODdh");
	        connection.setRequestProperty("Content-Type", "application/json");
	 
	        // POST the http body data
	        connection.setDoOutput(true);
	        connection.setRequestMethod("GET");
	        OutputStreamWriter writer = new OutputStreamWriter(connection.getOutputStream());
	        writer.write("");
	        writer.close();
	 
	        if (connection.getResponseCode() == HttpURLConnection.HTTP_OK) {
	            // OK
	            BufferedReader reader = new BufferedReader(new InputStreamReader(url.openStream()));
	            StringBuffer res = new StringBuffer(); 
	            String line;
	            while ((line = reader.readLine()) != null) {
	                res.append(line);
	            }
	            reader.close();
	            
	            log.warning("result of " + sUrl + " = \n" + res.toString());
	            json = new JSONObject(res.toString());
	 
	        } else {
	            // Server returned HTTP error code.
	        	BufferedReader reader = new BufferedReader(new InputStreamReader(url.openStream()));
	            StringBuffer res = new StringBuffer(); 
	            String line;
	            while ((line = reader.readLine()) != null) {
	                res.append(line);
	            }
	            reader.close();
	            log.log(Level.WARNING, "result: " + res.toString());
	        	throw new HttpResponseCodeException(connection.getResponseCode(), connection.getResponseMessage());
	        }
	 
		} catch (MalformedURLException ex) {
			log.log(Level.WARNING, "malformed url.  this should not happen as the input should have be vetted", ex);
		}
		
		return json;
//	    } catch (Exception e) {
//	    	return null;
//	    }
		
		
	}
	
	public static String callGet(String sUrl) 
			throws IOException, HttpResponseCodeException {
		String result = null;
		try {
			// 
	        URL url = new URL(sUrl);
	        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
	        //connection.setRequestProperty("Authorization", "Bearer ZDg2Njg1ZTgtMmE5OC00ZjIxLThkNmItYmM4ZDc0M2JmZTc1ODZkZDFmZDktNjQ1");
	        connection.setRequestProperty("Content-Type", "application/json; charset=utf-8");
	        //connection.setDoOutput(true);
	        //connection.setRequestMethod("POST");
	 
	        if (connection.getResponseCode() == HttpURLConnection.HTTP_OK) {
	            // OK
	            BufferedReader reader = new BufferedReader(new InputStreamReader(url.openStream()));
	            StringBuffer sb = new StringBuffer(); 
	            String line;
	            while ((line = reader.readLine()) != null) {
	            	sb.append(line).append(System.lineSeparator()); // should we append this with line break
	            }
	            reader.close();
	            
	            log.warning("result of " + sUrl + ": \n" + sb.toString());
	 
	            result = sb.toString();
	            //json = new JSONObject(sb.toString());
	            //int count = jsonObj.getInt("count");
	            
	        } else {
	            // Server returned HTTP error code.
	        	// throw exception
	        	throw new HttpResponseCodeException(connection.getResponseCode(), connection.getResponseMessage());
	        }
	 
		} catch (MalformedURLException ex) {
			log.log(Level.WARNING, "malformed url.  this should not happen as the input should have be vetted", ex);
		}
//	    } catch (Exception e) {
//	    	return null;
//	    }
		
		return result;
		
	}
	
	public static JSONObject jsonData(String sUrl) 
			throws IOException, HttpResponseCodeException {
		JSONObject json = null;
		try {
			// 
	        URL url = new URL(sUrl);
	        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
	        connection.setRequestProperty("Authorization", "Bearer ZDg2Njg1ZTgtMmE5OC00ZjIxLThkNmItYmM4ZDc0M2JmZTc1ODZkZDFmZDktNjQ1");
	        connection.setRequestProperty("Content-Type", "application/json; charset=utf-8");
	        //connection.setDoOutput(true);
	        //connection.setRequestMethod("POST");
	 
	        if (connection.getResponseCode() == HttpURLConnection.HTTP_OK) {
	            // OK
	            BufferedReader reader = new BufferedReader(new InputStreamReader(url.openStream()));
	            StringBuffer sb = new StringBuffer(); 
	            String line;
	            while ((line = reader.readLine()) != null) {
	            	sb.append(line).append(System.lineSeparator()); // should we append this with line break
	            }
	            reader.close();
	            
	            log.warning("result of " + sUrl + ": \n" + sb.toString());
	 
	            json = new JSONObject(sb.toString());
	            //int count = jsonObj.getInt("count");
	            
	        } else {
	            // Server returned HTTP error code.
	        	// throw exception
	        	throw new HttpResponseCodeException(connection.getResponseCode(), connection.getResponseMessage());
	        }
	 
		} catch (MalformedURLException ex) {
			log.log(Level.WARNING, "malformed url.  this should not happen as the input should have be vetted", ex);
		}
//	    } catch (Exception e) {
//	    	return null;
//	    }
		
		return json;
		
	}
	
	/**
	 * same as jsonData, except this returns JSONArray instead of 
	 * JSONObject.  the data in sUrl must be an array.
	 * @param sUrl
	 * @return
	 * @throws IOException
	 * @throws HttpResponseCodeException
	 */
	public static JSONArray jsonArray(String sUrl) 
			throws IOException, HttpResponseCodeException {
		JSONArray json = null;
		try {
			// 
	        URL url = new URL(sUrl);
	        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
	        connection.setRequestProperty("Content-Type", "application/json");
	 
	        if (connection.getResponseCode() == HttpURLConnection.HTTP_OK) {
	            // OK
	            BufferedReader reader = new BufferedReader(new InputStreamReader(url.openStream()));
	            StringBuffer sb = new StringBuffer(); 
	            String line;
	            while ((line = reader.readLine()) != null) {
	            	sb.append(line).append(System.lineSeparator()); // should we append this with line break
	            }
	            reader.close();
	 
	            json = new JSONArray(sb.toString());
	            //int count = jsonObj.getInt("count");
	            
	        } else {
	            // Server returned HTTP error code.
	        	// throw exception
	        	throw new HttpResponseCodeException(connection.getResponseCode(), connection.getResponseMessage());
	        }
	 
		} catch (MalformedURLException ex) {
			log.log(Level.WARNING, "malformed url.  this should not happen as the input should have be vetted", ex);
		}
//	    } catch (Exception e) {
//	    	return null;
//	    }
		
		return json;
		
	}
	
	
	public static String xmlData(String sUrl) 
			throws IOException, HttpResponseCodeException {
		String result = null;
		try {
			// 
	        URL url = new URL(sUrl);
	        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
	        //connection.setRequestProperty("Content-Type", "application/json");
	 
	        if (connection.getResponseCode() == HttpURLConnection.HTTP_OK) {
	            // OK
	            BufferedReader reader = new BufferedReader(new InputStreamReader(url.openStream()));
	            StringBuffer sb = new StringBuffer(); 
	            String line;
	            while ((line = reader.readLine()) != null) {
	            	sb.append(line).append(System.lineSeparator()); // should we append this with line break
	            }
	            reader.close();
	 
	            result = sb.toString();
	            //int count = jsonObj.getInt("count");
	            
	        } else {
	            // Server returned HTTP error code.
	        	// throw exception
	        	throw new HttpResponseCodeException(connection.getResponseCode(), connection.getResponseMessage());
	        }
	 
		} catch (MalformedURLException ex) {
			log.log(Level.WARNING, "malformed url.  this should not happen as the input should have be vetted", ex);
		}
//	    } catch (Exception e) {
//	    	return null;
//	    }
		
		return result;
		
	}
}
