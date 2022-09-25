import ConnectionInstance from './connection-instance';

import {GetArchiveCategoriesParams, GetArchiveListMaronryParams, GetArchiveListParams} from '@store/slices/archive';

export const getArchives = (params?: GetArchiveListParams) => ConnectionInstance.get('archives', { params });

export const getMasonryArchives = (params?: GetArchiveListMaronryParams) =>
    ConnectionInstance.get('archives-masonry', { params });

export const getMasonryWideArchives = (params?: GetArchiveListMaronryParams) =>
    ConnectionInstance.get('archives-masonry-wide', { params });

export const getArchiveCategories = (params?: GetArchiveCategoriesParams) =>
    ConnectionInstance.get('archive-categories', { params });

export const getArchiveDetail = (id: number) => ConnectionInstance.get('archives/' + id);
