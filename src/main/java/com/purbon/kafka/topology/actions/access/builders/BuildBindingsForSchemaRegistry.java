package com.purbon.kafka.topology.actions.access.builders;

import com.purbon.kafka.topology.AccessControlProvider;
import com.purbon.kafka.topology.actions.BaseAccessControlAction;
import com.purbon.kafka.topology.model.users.platform.SchemaRegistryInstance;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class BuildBindingsForSchemaRegistry extends BaseAccessControlAction {

  private final AccessControlProvider controlProvider;
  private final SchemaRegistryInstance schemaRegistry;

  public BuildBindingsForSchemaRegistry(
      AccessControlProvider controlProvider, SchemaRegistryInstance schemaRegistry) {
    super();
    this.controlProvider = controlProvider;
    this.schemaRegistry = schemaRegistry;
  }

  @Override
  public void run() throws IOException {
    bindings = controlProvider.buildBindingsForSchemaRegistry(schemaRegistry);
  }

  @Override
  protected Map<String, Object> props() {
    Map<String, Object> map = new HashMap<>();
    map.put("Operation", getClass().getName());
    map.put("Principal", schemaRegistry.getPrincipal());
    return map;
  }
}
