package pe.upc.pawfectcarebackend.petManagement.domain.services;

import pe.upc.pawfectcarebackend.petManagement.domain.model.aggregates.Owner;
import pe.upc.pawfectcarebackend.petManagement.domain.model.queries.GetAllOwnersQuery;
import pe.upc.pawfectcarebackend.petManagement.domain.model.queries.GetOwnerByIdQuery;

import java.util.List;
import java.util.Optional;

public interface OwnerQueryService {
  List<Owner> handle(GetAllOwnersQuery query);
  Optional<Owner> handle(GetOwnerByIdQuery query);
}
