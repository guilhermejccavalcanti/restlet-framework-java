/*
 * Copyright 2005-2006 Noelios Consulting.
 *
 * The contents of this file are subject to the terms
 * of the Common Development and Distribution License
 * (the "License").  You may not use this file except
 * in compliance with the License.
 *
 * You can obtain a copy of the license at
 * http://www.opensource.org/licenses/cddl1.txt
 * See the License for the specific language governing
 * permissions and limitations under the License.
 *
 * When distributing Covered Code, include this CDDL
 * HEADER in each file and include the License file at
 * http://www.opensource.org/licenses/cddl1.txt
 * If applicable, add the following below this CDDL
 * HEADER, with the fields enclosed by brackets "[]"
 * replaced with your own identifying information:
 * Portions Copyright [yyyy] [name of copyright owner]
 */

package org.restlet.service;

import java.util.List;

import org.restlet.data.Protocol;
import org.restlet.resource.Representation;

/**
 * Service providing client and server connectors.
 * @author Jerome Louvel (contact@noelios.com) <a href="http://www.noelios.com/">Noelios Consulting</a>
 */
public class ConnectorService
{
	/** The list of required client protocols. */
	private List<Protocol> requiredClientProtocols;

	/** The list of required server protocols. */
	private List<Protocol> requiredServerProtocols;
	
	/** The list of optional client protocols. */
	private List<Protocol> optionalClientProtocols;

	/** The list of optional server protocols. */
	private List<Protocol> optionalServerProtocols;
	
	/**
	 * Constructor.
	 */
	public ConnectorService()
	{
		this.requiredClientProtocols = null;
		this.requiredServerProtocols = null;
		this.optionalClientProtocols = null;
		this.optionalServerProtocols = null;
	}
	
	/**
	 * Call-back method invoked by the client or server connectors just before committing the entity to 
	 * the target component. The default implementation does nothing.
	 * @param entity The entity about to be committed.
	 */
	public void beforeCommit(Representation entity)
	{
		// Do nothing by default. 
	}
	
	/**
	 * Call-back method invoked by the client or server connectors just after committing the entity to 
	 * the target component. The default implementation does nothing.
	 * @param entity The entity about to be committed.
	 */
	public void afterCommit(Representation entity)
	{
		// Do nothing by default. 
	}

	/**
	 * Returns the list of required client protocols. 
	 * @return The list of required client protocols.
	 */
	public List<Protocol> getRequiredClientProtocols()
	{
		return this.requiredClientProtocols;
	}

	/**
	 * Returns the list of required server protocols. 
	 * @return The list of required server protocols.
	 */
	public List<Protocol> getRequiredServerProtocols()
	{
		return this.requiredServerProtocols;
	}
	
	/**
	 * Returns the list of optional client protocols. 
	 * @return The list of optional client protocols.
	 */
	public List<Protocol> getOptionalClientProtocols()
	{
		return this.optionalClientProtocols;
	}

	/**
	 * Returns the list of optional server protocols. 
	 * @return The list of optional server protocols.
	 */
	public List<Protocol> getOptionalServerProtocols()
	{
		return this.optionalServerProtocols;
	}

}
