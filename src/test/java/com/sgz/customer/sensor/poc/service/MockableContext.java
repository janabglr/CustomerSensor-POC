package com.sgz.customer.sensor.poc.service;

import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.web.context.support.XmlWebApplicationContext;

import java.util.concurrent.ConcurrentHashMap;

/**
 * User: Janardhan
 */
public class MockableContext extends XmlWebApplicationContext {

	private static ConcurrentHashMap<String, DefaultListableBeanFactory> factories = new ConcurrentHashMap<String, DefaultListableBeanFactory>();

	private static String getThreadId() {
		return Thread.currentThread().toString();
	}
	@Override
	protected DefaultListableBeanFactory createBeanFactory() {

		return factories.get(getThreadId());
	}

	public static void addMock(final String id, final Object mock) {

		final String threadId = getThreadId();
		if (factories.get(threadId) == null) {

			factories.put(threadId, new DefaultListableBeanFactory());
		}

		factories.get(threadId).registerSingleton(id, mock);
	}
    
    public static void cleanup() {
        final String threadId = getThreadId();

        if (factories.get(threadId) != null) {

            factories.remove(threadId);
        }
    }



}
