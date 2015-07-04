package io.underdark.example;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.EnumSet;
import java.util.Random;

import ch.qos.logback.classic.android.BasicLogcatConfigurator;
import io.underdark.transport.Link;
import io.underdark.transport.Transport;
import io.underdark.transport.TransportKind;
import io.underdark.transport.TransportListener;
import io.underdark.Underdark;


public class MainActivity extends Activity implements TransportListener
{
	private static Logger logger = LoggerFactory.getLogger(MainActivity.class);

	private Transport transport;

	private void configureLogging()
	{
		BasicLogcatConfigurator.configureDefaultContext();

		/*final LogConfigurator configurator = new LogConfigurator();

		configurator.setUseLogCatAppender(true);
		configurator.setUseFileAppender(false);
		configurator.setImmediateFlush(true);
		configurator.configure();*/
	}

	@Override
	protected void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		configureLogging();

		logger.info("Activity created");

		long nodeId = new Random().nextLong();
		if(nodeId < 0)
			nodeId = -nodeId;

		this.transport =
		Underdark.configureTransport(
				this.getApplicationContext().getPackageName().hashCode(),
				nodeId,
				this,
				null,
				this,
				EnumSet.of(TransportKind.WIFI, TransportKind.BLUETOOTH)
		);

		this.transport.start();
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu)
	{
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.menu_main, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item)
	{
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();

		//noinspection SimplifiableIfStatement
		if (id == R.id.action_settings)
		{
			return true;
		}

		return super.onOptionsItemSelected(item);
	}

	//region TransportListener
	@Override
	public void transportNeedsActivity(Transport transport, ActivityCallback activityCallback)
	{
		activityCallback.accept(this);
	}

	@Override
	public void transportLinkConnected(Transport transport, Link link)
	{
		logger.debug("link connected");
	}

	@Override
	public void transportLinkDisconnected(Transport transport, Link link)
	{
		logger.debug("link disconnected");
	}

	@Override
	public void transportLinkDidReceiveFrame(Transport transport, Link link, byte[] bytes)
	{
		logger.debug("link frame");
	}
	//endregion
} // MainActivity
