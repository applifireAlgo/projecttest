package com.app.shared.appinsight.alarms;
import java.util.List;

public class AppLogConfig {

	private String appConfigId;

	public String getAppConfigId() {
		return appConfigId;
	}

	public void setAppConfigId(String appConfigId) {
		this.appConfigId = appConfigId;
	}

	private List<LoggingProperties> loggingProperties;
	private List<Connectors> connectorArray;
	private List<AlarmSeverity> alarmSeverity;
	private List<LogCommons> logArchitectureLayer;
	private List<LogCommons> logStatus;
	private List<LogCommons> logEventAction;
	private List<LogException> logException;

	public List<AlarmSeverity> getAlarmSeverity() {
		return alarmSeverity;
	}

	public void setAlarmSeverity(List<AlarmSeverity> alarmSeverity) {
		this.alarmSeverity = alarmSeverity;
	}

	public List<Connectors> getConnectorArray() {
		return connectorArray;
	}

	public void setConnectorArray(List<Connectors> connectorArray) {
		this.connectorArray = connectorArray;
	}

	public List<LoggingProperties> getLoggingProperties() {
		return loggingProperties;
	}

	public void setLoggingProperties(List<LoggingProperties> loggingProperties) {
		this.loggingProperties = loggingProperties;
	}

	public List<LogCommons> getLogArchitectureLayer() {
		return logArchitectureLayer;
	}

	public void setLogArchitectureLayer(List<LogCommons> logArchitectureLayer) {
		this.logArchitectureLayer = logArchitectureLayer;
	}

	public List<LogCommons> getLogStatus() {
		return logStatus;
	}

	public void setLogStatus(List<LogCommons> logStatus) {
		this.logStatus = logStatus;
	}

	public List<LogCommons> getLogEventAction() {
		return logEventAction;
	}

	public void setLogEventAction(List<LogCommons> logEventAction) {
		this.logEventAction = logEventAction;
	}

	public List<LogException> getLogException() {
		return logException;
	}

	public void setLogException(List<LogException> logException) {
		this.logException = logException;
	}

	@Override
	public String toString() {
		return "AppLogConfig [loggingProperties=" + loggingProperties + ", connectorArray=" + connectorArray + ", alarmSeverity=" + alarmSeverity + ", logArchitectureLayer="
				+ logArchitectureLayer + ", logStatus=" + logStatus + ", logEventAction=" + logEventAction + ", logException=" + logException + "]";
	}

	/*@Override
	public String toString() {
		return "AppLogConfig [alarmSeverity = " + alarmSeverity + ", connectorArray = " + connectorArray + ", LoggingProperties = " + loggingProperties + "]";
	}*/
}
